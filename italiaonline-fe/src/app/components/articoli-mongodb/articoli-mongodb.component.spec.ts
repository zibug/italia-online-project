import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticoliMongodbComponent } from './articoli-mongodb.component';

describe('ArticoliMongodbComponent', () => {
  let component: ArticoliMongodbComponent;
  let fixture: ComponentFixture<ArticoliMongodbComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ArticoliMongodbComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ArticoliMongodbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
