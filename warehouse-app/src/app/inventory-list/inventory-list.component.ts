import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { WarehouseApiService } from '../warehouse-api.service';
import { WarehouseListComponent } from '../warehouse-list/warehouse-list.component';
import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { NgForm } from '@angular/forms';
import { _isNumberValue } from '@angular/cdk/coercion';


export interface WarehouseData {
  id: string;
  name: string;
  companyId: string;
  capacity: string;
  stock: string;
  favorited: string;
}

export interface ITEM {
  id: number;
  name: string;
  buildingId: number;
  buildingName: string;
  quanity: number;
}

@Component({
  selector: 'app-inventory-list',
  templateUrl: './inventory-list.component.html',
  styleUrls: ['./inventory-list.component.css'],

})
export class InventoryListComponent implements OnInit {


  service: WarehouseApiService;

  
  inventory: Array<any> = [];
  warehouses: Array<any> = [];

  editItem: any = {};
  createItem: any = {};

  createQuantity: number = 1;
  editQuantity: number = 0
  
  date: String = (new Date()).toISOString().split('T')[0];

  //exceeds: Boolean = false;
  isCreateFormHidden: Boolean = true;
  isEditFormHidden: Boolean = true;
  isConfirmationFormHidden: Boolean = true;
  errorNotFound: Boolean = true;
  modalHidden: Boolean = true;

  displayedColumns: string[] = ['name', 'date', 'building', 'quantity', 'edit/delete'];
  dataSource: MatTableDataSource<any>;
  length: number = 0;


  @ViewChild(MatPaginator, { static: true })
  paginator!: MatPaginator;

  @ViewChild(MatSort)
  sort: MatSort = new MatSort;

  constructor(service: WarehouseApiService) {
    this.service = service;
    this.dataSource = new MatTableDataSource(this.inventory)

  }
  loadEditData(event: any): void {
    this.editItem = {
      id: event.target.parentElement.getAttribute("data-item-id"),
      name: event.target.parentElement.getAttribute("data-item-name"),
      buildingId: event.target.parentElement.getAttribute("data-warehouse-id"),
      buildingName: event.target.parentElement.getAttribute("data-warehouse-name"),
    }
    this.editQuantity = event.target.parentElement.getAttribute("data-item-quantity")
    this.editItem.quantity = this.editQuantity;
  }
  revealDeleteConfirmation(event: any): void {
    this.loadEditData(event)
    this.hideCreateForm();
    this.hideEditForm()
    this.modalHidden = false
    this.isConfirmationFormHidden = false
  }
  hideDeleteConfirmation(): void {
    this.modalHidden = true
    this.isConfirmationFormHidden = true
  }
  revealEditForm(event: any): void {

    this.loadEditData(event)
    this.hideDeleteConfirmation()
    this.hideCreateForm()
    console.log("edit", this.editItem)
    this.modalHidden = false
    this.isEditFormHidden = false

  }
  hideEditForm(): void {

    this.modalHidden = true
    this.isEditFormHidden = true
  }
  revealCreateForm(): void {
    this.hideDeleteConfirmation()
    this.hideEditForm()
    this.modalHidden = false
    this.isCreateFormHidden = false
  }
  hideCreateForm(): void {
    this.modalHidden = true
    this.isCreateFormHidden = true
  }
  submit(event: any, action: string, createItem: any): void {
    event.preventDefault();
    if (action === 'create') {
      if (this.capacityCheck(this.createQuantity)) {
        createItem.quantity = this.createQuantity;
        console.log(createItem)
        this.service.addToInventory(createItem).subscribe(resp => {
        console.log("response", resp)
        })
      }
      else {

      }
    }
    else {
      if (this.capacityCheck(this.editQuantity)) {
        this.service.editInventory(this.editItem).subscribe(resp => {
        console.log("response", resp)
        })
      }
      else{

      }
    }


  }
  confirmed(): void {
    this.service.deleteInventory(this.editItem).subscribe(resp => {
      console.log("response", resp)
    })
  }
  handleSelect(): void {

  }
  closeForm(): void {

  }
  capacityCheck(quantity :any): Boolean {
    let capacity = this.warehouses.filter(x => x.id == this.editItem.buildingId)[0];
    capacity = capacity.capacity;
    if (quantity > capacity) {
      console.log("error")
      this.errorNotFound = false;
      let errorElement = document.querySelector(".edit-quantity");
      errorElement ? errorElement.classList.toggle("error") : null;
      return false;
    }
    else {
      if (this.errorNotFound == false) {
        this.errorNotFound = true;
        let errorElement = document.querySelector(".edit-quantity");
        errorElement ? errorElement.classList.toggle("error") : null;
      }
      return true;
    }
  }
    /*
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }*/
  ngOnInit(): void {
    this.service.getInventory().subscribe(data => {
      this.inventory = data
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
      this.length = data.length;
      console.log("length", this.length)
      console.log(this.inventory)
    });

    this.service.findAllWarehouses().subscribe(data => {
      this.warehouses = data;
    })
  }

}
