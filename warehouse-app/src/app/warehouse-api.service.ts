import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class WarehouseApiService {

  http :HttpClient;

  constructor(http :HttpClient) { 
    this.http = http;
  }

  findAllWarehouses() :Observable<any> {
    return this.http.get(environment.apiUrl + 'home');
  }
  getRecentActivity() :Observable<any> {
    return this.http.get(environment.apiUrl + 'Activity-list');
  }
  
}
