import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClassQuizzesComponent } from './class-quizzes.component';

describe('ClassQuizzesComponent', () => {
  let component: ClassQuizzesComponent;
  let fixture: ComponentFixture<ClassQuizzesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ClassQuizzesComponent]
    });
    fixture = TestBed.createComponent(ClassQuizzesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
