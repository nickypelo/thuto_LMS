import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { TeacherComponent } from './pages/teacher/teacher.component';
import { LearnerComponent } from './pages/learner/learner.component';
import { AuthComponent } from './pages/auth/auth.component';
import { SubjectComponent } from './components/learner/subject/subject.component';
import { QuizComponent } from './components/learner/quiz/quiz.component';
import { TopicComponent } from './components/learner/topic/topic.component';
import { NavigationComponent } from './components/navigation/navigation.component';
import { HeaderComponent } from './components/header/header.component';
import { QuestionComponent } from './components/question/question.component';
import { GradeComponent } from './components/grade/grade.component';
import { HttpClientModule } from '@angular/common/http';
import { AddStudentComponent } from './components/teacher/add-student/add-student.component';
import { StudentsComponent } from './components/teacher/students/students.component';
import { ClassTopicsComponent } from './components/teacher/class-topics/class-topics.component';
import { ClassQuizzesComponent } from './components/teacher/class-quizzes/class-quizzes.component';
import { ClassGradesComponent } from './components/teacher/class-grades/class-grades.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    TeacherComponent,
    LearnerComponent,
    AuthComponent,
    SubjectComponent,
    QuizComponent,
    TopicComponent,
    NavigationComponent,
    HeaderComponent,
    QuestionComponent,
    GradeComponent,
    AddStudentComponent,
    StudentsComponent,
    ClassTopicsComponent,
    ClassQuizzesComponent,
    ClassGradesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
