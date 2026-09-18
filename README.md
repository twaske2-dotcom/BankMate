# BankMate – Personal Banking (Android, Kotlin)

Academic demo app for basic customer account services.
All data is sample/simulated — no real banking or money transfers.

## How to open in Android Studio
1. Unzip this project.
2. Android Studio → File → Open → select the extracted `BankMate` folder.
3. Let Gradle sync (it will download the Gradle 8.4 wrapper distribution
   the first time — an internet connection is required).
4. Run the `app` configuration on an emulator or device (minSdk 24).

## Structure
- `MainActivity` – dashboard: customer name, account number, balance,
  and the 3 service cards (Account Details / Fund Transfer / Transaction History),
  each loaded via a Fragment into `fragmentContainer`.
- `fragments/AccountDetailsFragment` – static sample account info.
- `fragments/FundTransferFragment` – validated input form; on Confirm,
  builds an `Intent` with the transfer details and starts `TransactionActivity`.
- `TransactionActivity` – shows the transaction summary, fires a local
  notification (with channel + Android 13 runtime permission handling),
  and logs all lifecycle methods to Logcat under tag "BankMate".
- `fragments/TransactionHistoryFragment` – static sample transaction list
  in a RecyclerView.
- `model/Transaction.kt` – simple data class shared by history + transfer flow.

## Notes
- No wrapper jar binary is bundled (binary files can't ship well in a
  text-based zip build here) — Android Studio will offer to regenerate
  the Gradle wrapper automatically on first open, or run
  `gradle wrapper --gradle-version 8.4` once you have Gradle installed
  locally, then open the project again.
