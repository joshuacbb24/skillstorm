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
    return this.http.post(environment.apiUrl  + 'inventory/', item)
  }
  editInventory(item :any) :Observable<any> {
    return this.http.put(environment.apiUrl  + 'inventory/', item)
  }
  deleteInventory(item :number) :Observable<any> {
    return this.http.delete(environment.apiUrl + 'inventory/' + item)
  }
  toggleFavorite(warehouse :any) :Observable<any> {
    return this.http.put(environment.apiUrl + 'warehouse/', warehouse);
  }

  
}
