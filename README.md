# 🏦 BankMate – Personal Banking App

<p align="center">
  <b>💳 Modern & Premium Personal Banking Android Application</b>
</p>

<p align="center">
  Built with Kotlin and XML using Android Studio
</p>

---

## 📌 Project Overview

BankMate is a modern personal banking Android application developed using **Kotlin and XML** in **Android Studio**.

The application provides basic banking services such as **Account Details, Fund Transfer, Transaction History, and Transaction Notifications** through a clean, attractive, and user-friendly interface.

The project demonstrates important Android development concepts including **Activities, Fragments, Explicit Intents, UI Components, Notifications, Input Validation, and Activity Lifecycle methods**.

> ⚠️ **Disclaimer:**
> This application is developed for academic and educational purposes.
> It simulates banking transactions and does not process real money transfers or connect to actual banking systems.

---

## ✨ Features

### 🏦 Account Dashboard

* Customer name display
* Masked account number
* Available balance
* Banking service navigation
* Premium card-based interface

### 📋 Account Details

* Customer name
* Account number
* Account type
* Available balance
* Modern account information card

### 💸 Fund Transfer

* Beneficiary name input
* Account number input
* Transfer amount input
* IMPS, NEFT, and UPI selection
* Input validation
* Transfer confirmation

### 📄 Transaction Details

* Transaction success message
* Beneficiary details
* Account number
* Transfer amount
* Transfer mode
* Transaction status
* Done button

### 🔔 Notifications

* Transaction success notification
* NotificationManager
* NotificationChannel
* Android notification permission handling
* Notification displayed after successful simulated transaction

### 📜 Transaction History

* Sample transaction records
* Transaction amount
* Transfer mode
* Transaction status
* Attractive transaction cards

### 🔄 Activity Lifecycle

* `onCreate()`
* `onStart()`
* `onResume()`
* `onPause()`
* `onStop()`
* `onDestroy()`
* Logcat lifecycle monitoring

---

## 🛠️ Technologies Used

| Technology          | Purpose                               |
| ------------------- | ------------------------------------- |
| Kotlin              | Application development               |
| Android Studio      | Development environment               |
| XML                 | User interface design                 |
| Android SDK         | Android development                   |
| Activities          | Screen management                     |
| Fragments           | Modular UI sections                   |
| Explicit Intent     | Activity navigation and data transfer |
| NotificationManager | Notifications                         |
| NotificationChannel | Notification channel management       |
| Logcat              | Debugging and lifecycle monitoring    |
| Material Components | Modern UI design                      |

---

## 🎨 UI Design

BankMate follows a **modern and premium fintech banking design**.

### Design Highlights

* Clean and professional layout
* Modern banking dashboard
* Rounded cards and buttons
* Consistent typography
* Attractive color palette
* User-friendly input fields
* Responsive XML layouts
* Premium transaction summary cards
* Clear navigation
* Professional banking interface

---

## 📱 Application Screens

The application includes:

1. Account Dashboard
2. Account Details
3. Fund Transfer
4. Transaction History
5. Transaction Details / Success Screen
6. Transaction Notification

---

## 🏗️ Application Architecture

The application uses an **Activity + Fragment-based structure**.

```text
MainActivity
│
├── AccountDetailsFragment
│
├── FundTransferFragment
│       │
│       └── Confirm Transfer
│               │
│               └── Explicit Intent
│                       │
│                       └── TransactionActivity
│
└── TransactionHistoryFragment
```

---

## 📂 Project Structure

```text
BankMate/
│
├── app/
│   └── src/
│       └── main/
│           │
│           ├── java/com/example/bankmate/
│           │   │
│           │   ├── MainActivity.kt
│           │   ├── TransactionActivity.kt
│           │   │
│           │   ├── fragments/
│           │   │   ├── AccountDetailsFragment.kt
│           │   │   ├── FundTransferFragment.kt
│           │   │   └── TransactionHistoryFragment.kt
│           │   │
│           │   └── model/
│           │       └── Transaction.kt
│           │
│           ├── res/
│           │   ├── layout/
│           │   │   ├── activity_main.xml
│           │   │   ├── activity_transaction.xml
│           │   │   ├── fragment_account_details.xml
│           │   │   ├── fragment_fund_transfer.xml
│           │   │   └── fragment_transaction_history.xml
│           │   │
│           │   ├── drawable/
│           │   ├── mipmap/
│           │   │
│           │   └── values/
│           │       ├── colors.xml
│           │       ├── strings.xml
│           │       └── themes.xml
│           │
│           └── AndroidManifest.xml
│
└── build.gradle.kts
```

---

## 🔄 Application Workflow

### 1. Open Application

The user opens BankMate and views the account dashboard.

### 2. View Account Details

The user selects **Account Details** to view account information.

### 3. Fund Transfer

The user opens **Fund Transfer** and enters:

* Beneficiary Name
* Account Number
* Transfer Amount
* Transfer Mode

### 4. Confirm Transfer

The application validates the entered information.

### 5. Open Transaction Activity

The application uses an **Explicit Intent** to open `TransactionActivity`.

### 6. Display Transaction Details

`TransactionActivity` displays the transaction information and transaction status.

### 7. Notification

A notification is generated after the successful simulated transaction.

### 8. Done

The user clicks the **Done** button to return to the previous screen.

---

## 🧩 Android Components Used

### Activities

* `MainActivity`
* `TransactionActivity`

### Fragments

* `AccountDetailsFragment`
* `FundTransferFragment`
* `TransactionHistoryFragment`

### UI Components

* `TextView`
* `EditText`
* `Button`
* `RadioGroup`
* `RadioButton`
* Card-based layouts

### Android Features

* Explicit Intent
* Intent Extras
* NotificationManager
* NotificationChannel
* Activity Lifecycle
* Logcat
* Input Validation

---

## 🔐 Input Validation

The Fund Transfer screen validates user input before processing the transaction.

The application checks:

* Beneficiary name is not empty.
* Account number is not empty.
* Transfer amount is entered.
* Transfer amount is valid.
* Transfer amount is greater than zero.
* Transfer mode is selected.

If the input is invalid, the application displays an appropriate error message.

---

## 📤 Intent Implementation

BankMate uses an **Explicit Intent** to open `TransactionActivity` and transfers transaction data using Intent Extras.

```kotlin
val intent = Intent(
    requireContext(),
    TransactionActivity::class.java
)

intent.putExtra(
    "beneficiary",
    beneficiary.text.toString()
)

intent.putExtra(
    "account",
    account.text.toString()
)

intent.putExtra(
    "amount",
    amount.text.toString()
)

intent.putExtra(
    "mode",
    mode
)

startActivity(intent)
```

The following information is transferred:

* Beneficiary Name
* Account Number
* Transfer Amount
* Transfer Mode

---

## 🔔 Notification Implementation

The application generates a notification after a successful simulated transaction.

### Notification Features

* `NotificationManager`
* `NotificationChannel`
* Android notification permission handling
* Transaction success message
* Notification displayed after successful transfer

### Example Notification

```text
BankMate

Transaction successful
```

The notification informs the user that the simulated transaction has been completed successfully.

---

## 🔄 Activity Lifecycle

The application demonstrates the following Activity Lifecycle methods:

* `onCreate()`
* `onStart()`
* `onResume()`
* `onPause()`
* `onStop()`
* `onDestroy()`

Lifecycle messages are displayed in **Android Studio Logcat** using the `Log.d()` method.

### Example

```kotlin
Log.d(
    "BankMate",
    "onResume called"
)
```

These lifecycle methods help demonstrate how an Android Activity behaves during different stages of its execution.

---

## 🚀 How to Run the Project

### Step 1: Install Android Studio

Download and install **Android Studio** on your computer.

### Step 2: Clone the Repository

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
```

Replace `YOUR_GITHUB_REPOSITORY_URL` with your actual GitHub repository URL.

### Step 3: Open the Project

1. Open Android Studio.
2. Select **Open**.
3. Choose the **BankMate** project folder.
4. Wait for Gradle synchronization to complete.

### Step 4: Connect a Device

You can use:

* Android Emulator
* Physical Android Device

For a physical device, enable **Developer Options** and **USB Debugging**.

### Step 5: Run the Application

1. Select the target device.
2. Click the **Run ▶** button.
3. Wait for the application to build.
4. Test the BankMate application.

---

## 🧪 Testing

| Test Case                     | Expected Result                               |
| ----------------------------- | --------------------------------------------- |
| Open application              | Dashboard is displayed                        |
| Click Account Details         | Account Details Fragment opens                |
| Click Fund Transfer           | Fund Transfer Fragment opens                  |
| Enter valid transfer data     | Data is accepted                              |
| Leave required fields empty   | Validation message appears                    |
| Enter invalid transfer amount | Validation message appears                    |
| Select IMPS                   | IMPS mode is selected                         |
| Select NEFT                   | NEFT mode is selected                         |
| Select UPI                    | UPI mode is selected                          |
| Click Confirm Transfer        | TransactionActivity opens                     |
| View transaction details      | Transaction data is displayed                 |
| Complete simulated transfer   | Transaction success notification is generated |
| Click Done                    | Previous screen is displayed                  |
| Check Logcat                  | Lifecycle messages appear                     |

---

## 📸 Screenshots

Add your actual application screenshots below.

### 🏠 Account Dashboard

<img width="732" height="1600" alt="dash" src="https://github.com/user-attachments/assets/d7ae8f04-4335-4f9c-92fd-9f696627f99e" />


### 📋 Account Details

<img width="732" height="1600" alt="acc" src="https://github.com/user-attachments/assets/6858ae96-2b89-4013-a2ef-787754308eb0" />


### 💸 Fund Transfer

<img width="732" height="1600" alt="fund" src="https://github.com/user-attachments/assets/e1aee286-d6f7-4224-ac6d-82f3a078b971" />


### 📜 Transaction History

<img width="732" height="1600" alt="history" src="https://github.com/user-attachments/assets/3dd2e734-d38e-43e3-a4a1-071a42e701c2" />


### 📄 Transaction Details

<img width="1080" height="2358" alt="details" src="https://github.com/user-attachments/assets/2da13f24-98fd-4f26-9be7-5e14ce869661" />


### 🔔 Transaction Notification

<img width="732" height="1600" alt="noti" src="https://github.com/user-attachments/assets/aa2a635a-2f41-4f12-9c17-d877acd57331" />


---

## 📌 Conclusion

BankMate is a modern Android banking application developed using **Kotlin and XML**. The project demonstrates practical implementation of Android concepts such as **Activities, Fragments, Explicit Intents, Intent Extras, UI Components, Input Validation, Notifications, and Activity Lifecycle methods**.

The application provides a simulated banking experience with account information, fund transfer, transaction details, transaction history, and transaction notifications.

This project helped demonstrate the development of a structured, user-friendly Android application using fundamental Android development concepts.

---

## 👨‍💻 Author

**Tejas Sunil Waske**

MCA Student
Android Application Development using Kotlin & XML
