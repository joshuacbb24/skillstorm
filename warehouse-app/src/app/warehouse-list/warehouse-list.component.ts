import {AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { WarehouseApiService } from '../warehouse-api.service';
import {MatSort} from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';


export interface WarehouseData {
  id: string;
  name: string;
  companyId: string;
  capacity: string;
  stock: string;
  favorited: string;
}

@Component({
  selector: 'app-warehouse-list',
  templateUrl: './warehouse-list.component.html',
  styleUrls: ['./warehouse-list.component.css']
})
export class WarehouseListComponent implements OnInit {

  service :WarehouseApiService;
  warehouses :Array<WarehouseData> = [];
  displayedColumns: string[] = ['name', 'address', 'zip', 'stock', 'capacity', 'star'];
  //arrayLength :number = 0;
  dataSource: MatTableDataSource<any>;

  isCreateFormHidden: Boolean = true;
  isEditFormHidden: Boolean = true;
  isConfirmationFormHidden: Boolean = true;
  errorNotFound: Boolean = true;
  modalHidden: Boolean = true;


  @ViewChild(MatPaginator, { static: true })
  paginator!: MatPaginator;

  @ViewChild(MatSort)
  sort: MatSort = new MatSort;

  constructor(service :WarehouseApiService) {
    this.service = service;
    this.dataSource = new MatTableDataSource(this.warehouses)
   }
  revealCreateForm() :void {
    
  }
  hideCreateForm() :void {

  }
  revealEditForm() :void {
    
  }
  hideEditForm() :void {

  }
  toggleStar(warehouse :any) :void {
    console.log("toggle star", warehouse)
    this.service.toggleFavorite(warehouse).subscribe(data => {
      this.update();
    })

  }
  update() :void {
    this.service.findAllWarehouses().subscribe(data => {
      this.warehouses = data;
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    })
  }
  ngOnInit(): void {
    //this.dataSource = new MatTableDataSource(this.warehouses);
    let navbar = document.getElementById('dashboard');
    navbar ? navbar.innerText = "Warehouses" : null;
    this.update();
    //this.showPages();

    //this.arrayLength = this.warehouses.length; 
  }

}
