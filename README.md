# Employee Record Management Project

This project is an implementation of an employee record management system using a linked list data structure. 
 -project developed for the University of Jeddah Data Structure course.
 -Focuses on implementing an employee record management system using various data structures and algorithms.
 



General overview of what the program does:
1. Creating Employee Records:
   - Users can input employee details such as ID, name, first day of work, phone number, address, work hours, and salary.
   - The program checks if an employee with the provided ID already exists and displays a message accordingly.
   - If the employee doesn't exist, a new record is created and added to the employee record management system.
     
2. Deleting Employee Records:
   - Users can input an employee ID to delete the corresponding record.
   - The program checks if the employee exists and deletes the record if found.
   - Appropriate messages are displayed based on the success or failure of the deletion operation.

3. Updating Employee Records:
   - Users can update employee information by providing an employee ID.
   - The program allows users to update various fields such as name, first day of work, phone number, address, and work hours.
   - The updated information is reflected in the employee record.

4. Updating Employee Salaries:
   - Users can update an employee's salary by providing the employee ID.
   - The program prompts users to enter the new salary, and the corresponding record is updated.

5. Searching for Specific Employee Records:
   - Users can search for an employee record by providing the employee ID.
   - The program performs a search operation and displays the employee's information if found.

6. Displaying All Employee Records:
   - Users can choose to display all the employee records stored in the system.
   - The program retrieves and displays all the employee details, including ID, name, first day of work, phone number, address, work hours, and salary.




## Project Structure
The project is organized into the following components:

### EmployeeRecordManagementProject Class
This class serves as the main class for the project and contains the implementation of the linked list data structure. It includes the following fields and methods:

#### Node Class

This nested class represents a node in the linked list. Each node stores information about an employee, including their ID, name, day, phone number, address, hours worked, and salary. It also contains a reference to the next node in the list.

##### Fields
- `name`: The name of the employee.
- `day`: The day the employee's record was created.
- `phoneNumber`: The phone number of the employee.
- `address`: The address of the employee.
- `hours`: The number of hours worked by the employee.
- `salary`: The salary of the employee.
- `ID`: The ID of the employee.
- `next`: A reference to the next node in the list.

##### Constructor
The constructor of the `Node` class accepts arguments to initialize the fields of the node.

#### Methods
- `checkRecord(int Id_record)`: This method checks if an employee record with the given ID already exists in the system. It traverses the linked list and returns `true` if a record with the given ID is found, otherwise `false`.

- `CreateRecord(int ID, String name, String day, String phoneNumber, String address, double hours, double salary)`: This method adds a new employee record to the system. It creates a new node with the provided information and inserts it into the linked list in a sorted manner based on the employee's ID.

- `SmartSerchRecord(int serchedID)`: This method searches for an employee record with the given ID in the linked list. It returns the node containing the record if found, otherwise it prints a message indicating that the employee with the specified ID is not registered.

- `DeleteRecored(int deletedID)`: This method deletes an employee record with the given ID from the linked list. It searches for the record based on the ID and removes it from the list. It returns `-1` if the record does not exist or the list is empty, otherwise `0` indicating that the deletion was successful.

- `DeleteRecored(int deletedID)`: This method is responsible for deleting an employee record with the given ID from the linked list. It searches for the record based on the ID and removes it from the list. If the record is found, it updates the pointers of the previous node to skip the deleted node. Finally, it returns `0` to indicate a successful deletion. If the record does not exist or the list is empty, it returns `-1`.

- `showRecord()`: This method prints all the elements (employee records) in the linked list. It traverses the list from the `head` node to the last node, printing each employee's information, such as ID, name, first day of work, phone number, address, working hours, and salary.

- `updateSalary(int serch_ID)`: This method updates the salary of an employee with the given ID. It first calls the `SmartSerchRecord` method to find the employee record. If the record exists, it checks if the employee has worked more than 32 hours. If so, it calculates the extra salary based on the overtime hours and updates the employee's salary accordingly. Finally, it prints the new salary.

- `updateEmployee(int updated_ID)`: This method updates the information of an employee with the given ID. It checks if the employee record exists by calling the `checkRecord` method. If the record is found, it prompts the user to choose the field they want to update (such as name, first day of work, phone number, address, working hours, or salary). It then takes the new value from the user and updates the corresponding field of the employee record. After each update, it prints a success message. This method uses a `do-while` loop to allow multiple updates in a single session.


### README Conclusion
Here's a breakdown of the main parts of the code:

1. The `main` method:
   - It displays a menu using the `menu()` method.
   - Based on the user's choice, it calls different methods of the `EmployeeRecordManagementProject` class to perform operations.
   - It continues to display the menu until the user chooses to exit.

2. The `menu()` method:
   - It displays a menu of options for the user to choose from.

3. The `EmployeeRecordManagementProject` class:
   - It contains methods for creating, deleting, updating, searching, and displaying employee records.
   - The `CreateRecord` method is used to create a new employee record.
   - The `DeleteRecord` method is used to delete an existing employee record.
   - The `updateEmployee` method is used to update employee information such as name, day of work, phone number, and address.
   - The `updateSalary` method is used to update the salary of an employee.
   - The `SmartSearchRecord` method is used to search for a specific employee record based on the ID.
   - The `showRecord` method is used to display all employee records.
