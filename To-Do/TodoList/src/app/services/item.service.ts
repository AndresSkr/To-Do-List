import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BASE_URL } from 'src/environments/environment';
import { Item } from '../model/item.interface';


const httpOptions = {
  headers: new HttpHeaders,
  'Content-Type': 'application/json'
}

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor(private http:HttpClient) { }

  public addItem(name,Task){
    return  this.http.post<Item>(BASE_URL + 'Item',{'name': name,'done':false,'taskCode':{'id':Task.id,'name':Task.name}},httpOptions).subscribe((data)=>{
      console.log(data);
    });
  }

  public editItem(item){
      this.http.put<Item>(BASE_URL + 'Item/Update/' + item.id,  {'id': item.id ,'name': item.name,'done':item.done,'taskCode':{'id':item.taskCode.id,'name':item.taskCode.name} }, httpOptions).
        subscribe(result => {
          console.log(result);
        },
          error => console.log(error));
    
  }


  public deleteItem(item) {
    this.http.delete<Item>(BASE_URL + 'Item/Delete/'+item.id, httpOptions).
      subscribe(result => {
        console.log(result);
      },
        error => console.log(error));
  }

}
