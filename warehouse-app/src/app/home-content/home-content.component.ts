import { Component, OnInit } from '@angular/core';
import { WarehouseApiService } from '../warehouse-api.service';

@Component({
  selector: 'app-home-content',
  templateUrl: './home-content.component.html',
  styleUrls: ['./home-content.component.css']
})
export class HomeContentComponent implements OnInit {

  service :WarehouseApiService;
  warehouses :Array<any> = [];
  actions :Array<any> = [];
  //arrayLength :number = 0;

  constructor(service :WarehouseApiService) {
    this.service = service;
  }

  ngOnInit(): void {
    this.service.findAllWarehouses().subscribe(data => {
      this.warehouses = data
      console.log(this.warehouses)
    });
    this.service.getRecentActivity().subscribe(data => {
      this.actions = data
      console.log(this.actions)
    });
  }
}
