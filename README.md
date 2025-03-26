# Product API

This is a Spring Boot-based project that provides a REST API for managing products. The application interacts with a PostgreSQL database and handles errors using custom exceptions.

## How to Run the Project

### Prerequisites
- Java 21
- Maven
- PostgreSQL

### Steps to Run the Application

1. **Clone the Repository:**
    ```bash 
    git clone https://github.com/coelhocj/productsapi.git

2. **Update application.properties:**
   - Update the database connection details in the application.properties file.
   - Make sure to use the correct database name, username, and password.
   
3. **Build the Project:**
   - Run the following command in the terminal:
   ```bash 
   mvn clean install
   
4. **Start the Application:**
   - Run the project

   
5. **Test the Application:**
   - Open a web browser and navigate to http://localhost:8080/api/products/
   - You should see a list of products displayed.

## Endpoints

The application provides the following endpoints:

### GET /api/products/
Returns a list of products.

#### Response
A JSON array containing the list of products.

Example:
```json
[
  {
    "barcode": "123456",
    "item": "Product A",
    "category": "Category 1",
    "price": 100,
    "discount": 10,
    "available": 5
  },
  {
    "barcode": "789012",
    "item": "Product B",
    "category": "Category 2",
    "price": 200,
    "discount": 20,
    "available": 10
  }
]
```

### GET /api/products/filter/price/{initialRange}/{finalRange}
Filters products based on their price range.

#### Parameters
- `initialRange`: The lower bound of the price range.
- `finalRange`: The upper bound of the price range.

#### Response
A JSON array containing the filtered products.

Example:
```json
[
  {
    "barcode": "123456",
    "item": "Product A",
    "category": "Category 1",
    "price": 100,
    "discount": 10,
    "available": 5
  }
]
```

### GET /api/products/sort/price
Sorts products by price.

#### Parameters
None

#### Response
A JSON array containing the sorted product names.

Example:
```json
[
  "Product A",
  "Product B"
]
```
