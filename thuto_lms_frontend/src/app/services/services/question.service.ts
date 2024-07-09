import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Question } from '../models/question';
import { environment } from 'src/app/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  private url = `${environment.apiUrl}/question`;

  constructor(private http: HttpClient) { }

  getAllQuestions(): Observable<Question[]>{
    return this.http.get<Question[]>(this.url);
  }
}
