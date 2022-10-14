// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyClKyrVYgdVJeYMWLPwl0U0LLZ4PGVThsk",
  authDomain: "ecse428-e1798.firebaseapp.com",
  projectId: "ecse428-e1798",
  storageBucket: "ecse428-e1798.appspot.com",
  messagingSenderId: "796575084902",
  appId: "1:796575084902:web:e58535f064a4ec978b18a7",
  measurementId: "G-RKLXGGPXFX"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);