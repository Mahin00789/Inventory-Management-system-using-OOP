# Inventory Management System

## Overview
The **Inventory Management System** is a Java-based console application designed to automate inventory tracking, stock management, and transaction logging. It allows users to efficiently manage products, monitor stock levels, and track sales and purchases.

## Features
- **Add Products**: Users can input product details like name, category, price, quantity, and expiration date.
- **Update Product Information**: Modify existing product details.
- **Stock Management**: Track inventory levels, reorder products, and manage stock purchases and sales.
- **Transaction History**: Automatically logs product additions, updates, purchases, and sales.
- **Reporting**: Displays inventory details, total inventory value, and generates transaction reports.
- **Persistent Storage**: Uses file handling to save and load inventory data.

## Technologies Used
- **Programming Language**: Java
- **Data Structures**: HashMap for inventory storage, ArrayList for transaction history
- **Serialization**: Saves and loads inventory data using ObjectOutputStream and ObjectInputStream
- **Exception Handling**: Ensures smooth operations with error handling
- **Date Handling**: Uses `SimpleDateFormat` for managing product expiration dates

## Installation & Usage
1. Clone the repository:
   ```sh
   git clone https://github.com/your-username/inventory-management-system.git
   ```
2. Navigate to the project directory:
   ```sh
   cd inventory-management-system
   ```
3. Compile the Java files:
   ```sh
   javac -d bin -sourcepath src src/MainApp.java
   ```
4. Run the application:
   ```sh
   java -cp bin MainApp
   ```

## How to Use
1. Start the program and follow the menu prompts.
2. Choose from the available options:
   - Add new products
   - View inventory details
   - Update product attributes
   - Buy or sell products
   - Remove products
   - View transaction history
   - Save and exit
3. The system automatically logs all transactions and updates inventory records.

## Contribution
Contributions are welcome! To contribute:
1. Fork the repository.
2. Create a new branch (`feature-branch`):
   ```sh
   git checkout -b feature-branch
   ```
3. Commit your changes:
   ```sh
   git commit -m "Add new feature"
   ```
4. Push to the branch:
   ```sh
   git push origin feature-branch
   ```
5. Open a Pull Request.

## License
This project is licensed under the MIT License. Feel free to use and modify it for personal or commercial use.

## Authors
- Jyot Konkani (23BCE147)
- Mahin Mehta (23BCE161)

For any queries, please reach out via GitHub Issues.

