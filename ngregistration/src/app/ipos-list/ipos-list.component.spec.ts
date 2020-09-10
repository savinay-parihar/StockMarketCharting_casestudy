import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IposListComponent } from './ipos-list.component';

describe('IposListComponent', () => {
  let component: IposListComponent;
  let fixture: ComponentFixture<IposListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IposListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IposListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
