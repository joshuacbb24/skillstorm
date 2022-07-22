import { AfterViewInit, Component, OnInit, ViewChild, ViewChildren, QueryList, ElementRef, Input  } from '@angular/core';
import { WarehouseApiService } from '../warehouse-api.service';
import { WarehouseListComponent } from '../warehouse-list/warehouse-list.component';
import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { NgForm } from '@angular/forms';
import { _isNumberValue } from '@angular/cdk/coercion';
import { NavbarComponent } from '../navbar/navbar.component';


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

  createQuantity: any = 1;
  editQuantity: any = 0
  
  date = new Date();
  

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
  /**
   * It takes the data from the table row that was clicked and assigns it to the editItem object
   * @param {any} event - any - this is the event that is triggered when the user clicks on the edit
   * button.
   */
  loadEditData(event: any): void {
    this.editItem = {
      id: event.target.parentElement.getAttribute("data-item-id"),
      name: event.target.parentElement.getAttribute("data-item-name"),
      buildingId: event.target.parentElement.getAttribute("data-warehouse-id"),
      oldBuildingId: event.target.parentElement.getAttribute("data-warehouse-id"),
      buildingName: event.target.parentElement.getAttribute("data-warehouse-name"),
    }
    this.editQuantity = event.target.parentElement.getAttribute("data-item-quantity")
    this.editItem.quantity = this.editQuantity;
  }
  revealDeleteConfirmation(event: any): void {
    this.loadEditData(event)
    this.modalHidden = false
    this.isConfirmationFormHidden = false
  }
  hideDeleteConfirmation(): void {
    this.modalHidden = true
    this.isConfirmationFormHidden = true
  }
  revealEditForm(event: any): void {

    this.loadEditData(event)
    console.log("edit", this.editItem)
    this.modalHidden = false
    this.isEditFormHidden = false
    this.editItem.date = this.date.getFullYear() + "-" + (this.date.getMonth() + 1) + "-" + this.date.getDate();;

  }
  hideEditForm(form :NgForm): void {
    this.modalHidden = true
    this.isEditFormHidden = true
    this.errorNotFound = true
    //form.reset();
  }
  revealCreateForm(): void {
    this.modalHidden = false
    this.isCreateFormHidden = false
    this.createQuantity = 1
    this.createItem.date = this.date.getFullYear() + "-" + (this.date.getMonth() + 1) + "-" + this.date.getDate();

  }
  hideCreateForm(form :NgForm): void {
    this.modalHidden = true
    this.isCreateFormHidden = true
    this.errorNotFound = true
    form.reset();
  }
    confirmed(): void {
    this.service.deleteInventory(this.editItem.id).subscribe(resp => {
      this.update();
    })
    this.hideDeleteConfirmation();
  }
  handleSelect(event :any): void {
    let text = event.target.options[event.target.options.selectedIndex].text;
    console.log("selected",text);
    this.createItem.buildingName = text;
  }
  /**
   * This function is called when the user clicks the submit button on the form. It prevents the
   * default action of the form, sets the date of the item to the current date, and then checks if the
   * user is creating or editing an item. If the user is creating an item, it checks if the quantity is
   * valid, and if it is, it adds the item to the inventory. If the user is editing an item, it checks
   * if the quantity is valid, and if it is, it edits the item in the inventory
   * @param {any} event - any - the event that is triggered when the form is submitted
   * @param {string} action - string - this is the action that the form is performing. It can be either
   * 'create' or 'edit'.
   * @param {any} itemObject - This is the object that is being passed in from the form.
   */
  submit(event: any, action: string, itemObject: any, form: NgForm): void {
    event.preventDefault();
    


    /* This is checking if the name and buildingId fields are not empty. */
    if((itemObject.name != undefined && itemObject.name != '') && (itemObject.buildingId != undefined  && itemObject.buildingId != ''))
    {


    /* This is checking if the user is creating an item and if the quantity is not 0 or empty. */
    if (action === 'create' && (this.createQuantity != 0 && this.createQuantity != '')) {
      if (this.capacityCheck(this.createQuantity, itemObject, 0)) {
        itemObject.quantity = this.createQuantity;
        console.log(itemObject)
        this.service.addToInventory(itemObject).subscribe(resp => {
        console.log("response", resp)
        this.update();
        })
        this.hideCreateForm(form);
        //form.reset();
      }
      
    }
  
/* This is checking if the user is editing an item and if the quantity is not 0 or empty. */
    else if (action === 'edit' && this.editQuantity != '') {
      
      if (this.capacityCheck(this.editQuantity, itemObject, 1)) {
        itemObject.quantity = this.editQuantity;
        this.service.editInventory(itemObject).subscribe(resp => {
        console.log("response", resp)
        this.update();
        })
        this.hideEditForm(form);
        //form.reset();
      }
    }
  }
  }


  /**
   * It checks if the quantity of the item is greater than the capacity of the warehouse
   * @param {any} quantity - The quantity that the user wants to add.
   * @param {any} itemObject - The item object that is being edited.
   * @returns A boolean value.
   */
  capacityCheck(quantity :any, itemObject :any, choice :number): Boolean {
    /* Getting the warehouse that the item is in. */
    let warehouse = this.warehouses.filter(x => x.id == itemObject.buildingId)[0];
    let capacity = warehouse.capacity; 
    let stock = warehouse.stock;

    /* Checking if the user is editing an item. If the user is editing an item, the quantity
    that the user wants to add is the difference between the quantity that the user wants to add and
    the quantity that the item currently has. */
    if (choice === 1)
    {
    quantity = quantity - itemObject.quantity;
    } 

    /* Checking if the quantity that the user wants to add is greater than the capacity of the
    warehouse. */
    if (Number(quantity) + stock > capacity) {
      console.log("error")
      this.errorNotFound = false;
      return false;
    }
    else {
      if (this.errorNotFound === false) {
        this.errorNotFound = true;
      }
      return true;
    }
  }
  /**
   * The update() function is called when the page loads and when the user clicks the refresh button.
   * It calls the getInventory() function in the inventory.service.ts file, which makes a GET request
   * to the server. The data returned from the server is stored in the inventory array, which is then
   * used to populate the table
   */
  update() :void {
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
    /*
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }*/

  /**
   * The function gets the inventory from the service and then sets the dataSource to the inventory
   */
  ngOnInit(): void {
    let navbar = document.getElementById('dashboard');
    navbar ? navbar.innerText = "Inventory" : null;

    console.log(navbar);
    this.update();
  }

}
