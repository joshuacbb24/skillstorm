import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FilterInventoryComponent } from './filter-inventory.component';

describe('FilterInventoryComponent', () => {
  let component: FilterInventoryComponent;
  let fixture: ComponentFixture<FilterInventoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FilterInventoryComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FilterInventoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
