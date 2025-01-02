// Import the functions you need from the SDKs you need
import { initializeApp } from 'firebase/app'
import { getAnalytics } from 'firebase/analytics'

const firebaseConfig = {
  apiKey: 'AIzaSyBaFcM11MBKFtt4qGNKLZ_1s3USO2lxQVE',
  authDomain: 'dataedu-web.firebaseapp.com',
  projectId: 'dataedu-web',
  storageBucket: 'dataedu-web.firebasestorage.app',
  messagingSenderId: '720724397091',
  appId: '1:720724397091:web:beccfb833dc0b6ff37f596',
  measurementId: 'G-Q0XHE6ZFJW'
}

// Initialize Firebase
const app = initializeApp(firebaseConfig)
const analytics = getAnalytics(app)
analytics.app.automaticDataCollectionEnabled = true
