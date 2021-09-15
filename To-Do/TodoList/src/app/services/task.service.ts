import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Task, Tasks } from '../model/task.interface';
import { BASE_URL } from 'src/environments/environment';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders,
  'Content-Type': 'application/json'
}

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  constructor(private http: HttpClient) { }

  task(): Observable<Tasks[]> {
    return this.http.get<Tasks[]>(BASE_URL + 'Task')
  }

   addTask(name) {
      this.http.post<Tasks>(BASE_URL + 'Task', { 'name': name }, httpOptions).subscribe( (data) => {
        data;
       console.log("dato agregado");
    });
    return true;


  }

   Delete(id) {
     this.http.delete<Tasks>(BASE_URL + 'Task/' + id, httpOptions).
      subscribe(result => {
        console.log(result);
      },
        error => console.log(error));
    return true;
  }

}
