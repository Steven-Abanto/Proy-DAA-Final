import {
  ApplicationConfig,
  provideBrowserGlobalErrorListeners,
  provideZonelessChangeDetection,
} from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { initializeApp, provideFirebaseApp } from '@angular/fire/app';
import { getAuth, provideAuth } from '@angular/fire/auth';
import { getFirestore, provideFirestore } from '@angular/fire/firestore';
import { provideAnimations } from '@angular/platform-browser/animations';
import { provideToastr } from 'ngx-toastr';
import { provideHttpClient, withFetch, withInterceptorsFromDi } from '@angular/common/http';

export const appConfig: ApplicationConfig = {
  providers: [
    provideFirebaseApp(() =>
      initializeApp({
          apiKey: "AIzaSyAhLMYtfL2XjQthfirPW7O_xKgIJk2KLNA",
          authDomain: "formulario-react-daa.firebaseapp.com",
          databaseURL: "https://formulario-react-daa-default-rtdb.firebaseio.com",
          projectId: "formulario-react-daa",
          storageBucket: "formulario-react-daa.firebasestorage.app",
          messagingSenderId: "56310763808",
          appId: "1:56310763808:web:159cf1f7347076e3a70745"
      })
    ),
    provideAuth(() => getAuth()),
    provideFirestore(() => getFirestore()),
    provideBrowserGlobalErrorListeners(),
    provideZonelessChangeDetection(),    
    provideRouter(routes),
    provideAnimations(),
    provideToastr(),
    provideHttpClient(),
    provideHttpClient(
      withFetch(),               // 👉 usa Fetch en lugar de XHR (desaparecen los avisos)
      withInterceptorsFromDi(),  // (opcional) si tienes interceptores registrados por DI
    ),
  ],
};
