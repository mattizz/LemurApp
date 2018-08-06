import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ContentComponent } from './content/content.component';
import { HttpService} from "./services/Http.service";
import { HttpClientModule} from "@angular/common/http";
import { ItemComponent } from './item/item.component';
import { RegisterComponent } from './register/register.component';
import { ReversePipe } from './pipes/reverse.pipe';
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    ContentComponent,
    ItemComponent,
    RegisterComponent,
    ReversePipe,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [HttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
