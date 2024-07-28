import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClassTopicsComponent } from './class-topics.component';

describe('ClassTopicsComponent', () => {
  let component: ClassTopicsComponent;
  let fixture: ComponentFixture<ClassTopicsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ClassTopicsComponent]
    });
    fixture = TestBed.createComponent(ClassTopicsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
