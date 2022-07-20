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

  saveItem(item :any) :Observable<any> {
    return this.http.post(environment.apiUrl, item);
  }
  findfavoriteWareshouses() :Observable<any> {
    return this.http.get(environment.apiUrl + 'home');
  }
  findAllWarehouses() :Observable<any> {
    return this.http.get(environment.apiUrl + 'warehouse');
  }
  getInventory() :Observable<any> {
    return this.http.get(environment.apiUrl + 'inventory');
  }
  getRecentActivity() :Observable<any> {
    return this.http.get(environment.apiUrl + 'activity-list');
  }
  
  addToInventory(item :any) :Observable<any> {
    return this.http.post(environment.apiUrl, item)
  }
  editInventory(item :any) :Observable<any> {
    return this.http.post(environment.apiUrl, item)
  }
  
}
