import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/app/environments/environment';
import { Quiz } from '../models/quiz';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  private url = `${environment.apiUrl}/quiz`
  constructor(private http:HttpClient) { }

  getAllQuizzes(): Observable<Quiz[]>{
    return this.http.get<Quiz[]>(this.url);
  }

  
}
