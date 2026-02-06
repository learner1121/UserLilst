# UserList Android App

A simple Android application built using Kotlin and Jetpack Compose that fetches and displays a list of users from a public REST API. The app follows MVVM architecture and demonstrates clean UI state management using StateFlow.

---

## 📱 Features

- Fetch users from a REST API
- Display user list on Home Screen
- Navigate to Detail Screen on user click
- Show loading and error states
- Clean and simple Material UI

---

## 🛠 Tech Stack

- Kotlin
- Jetpack Compose
- MVVM Architecture
- Retrofit
- OkHttp
- Kotlin Coroutines
- StateFlow

---

## 🔗 API Used
https://jsonplaceholder.typicode.com/users

---

## 📂 App Flow

1. Home Screen fetches and displays list of users  
2. User taps on a card  
3. Navigates to Detail Screen  
4. Detail Screen reuses already fetched data (no extra API call)

---

## ▶️ How to Run

1. Clone the repository  
2. Open the project in Android Studio  
3. Sync Gradle files  
4. Run on emulator or physical device  

---

## 🧱 Architecture
- UI->ViewModel->API

- Single API call
- Shared ViewModel between List and Detail screens
- Lifecycle-aware data handling

---

## ✅ What This Project Demonstrates

- API integration using Retrofit
- Jetpack Compose Navigation
- MVVM architecture
- UI state handling with StateFlow
- Clean and readable code structure

---

## 📌 Future Improvements

- Add Repository
- Add offline caching
- Improve error handling
- Add pagination
- Add UI tests

---


