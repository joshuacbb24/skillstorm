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
  displayedColumns: string[] = ['name', 'address', 'stock', 'capacity', 'edit', 'star'];
  //arrayLength :number = 0;
  dataSource: MatTableDataSource<any>;


  @ViewChild(MatPaginator, { static: true })
  paginator!: MatPaginator;

  @ViewChild(MatSort)
  sort: MatSort = new MatSort;

  constructor(service :WarehouseApiService) {
    this.service = service;
    this.dataSource = new MatTableDataSource(this.warehouses)
   }

  ngOnInit(): void {
    //this.dataSource = new MatTableDataSource(this.warehouses);
   
    this.service.findAllWarehouses().subscribe(data => {
      this.warehouses = data;
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    })
    //this.showPages();

    //this.arrayLength = this.warehouses.length; 
  }

}
