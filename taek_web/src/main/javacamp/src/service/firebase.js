import { initializeApp } from "https://www.gstatic.com/firebasejs/9.9.3/firebase-app.js";

const firebaseConfig = {
  apiKey: "AIzaSyD_E3njzteRHKiYoc24ioUvfD4thpJlOgM",
  authDomain: "d-gym-demo.firebaseapp.com",
  databaseURL: "https://d-gym-d emo-default-rtdb.asia-southeast1.firebasedatabase.app",
  projectId: "d-gym-demo",
  storageBucket: "d-gym-demo.appspot.com",
  messagingSenderId: "740962178337",
  appId: "1:740962178337:web:a7e0d4e2e2e9e9288a9a60"
};
// Initialize Firebase
export const firebaseApp = initializeApp(firebaseConfig);
console.log(firebaseApp);