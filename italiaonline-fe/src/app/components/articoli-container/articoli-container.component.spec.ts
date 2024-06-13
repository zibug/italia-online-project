import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticoliContainerComponent } from './articoli-container.component';

describe('ArticoliContainerComponent', () => {
  let component: ArticoliContainerComponent;
  let fixture: ComponentFixture<ArticoliContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ArticoliContainerComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ArticoliContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
