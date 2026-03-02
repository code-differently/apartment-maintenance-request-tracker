# Apartment Maintenance Request Tracker

### Keep the Building Running.

You are building a simple console application that helps an apartment complex track maintenance requests.

Tenants submit issues.
The office logs them.
Techs get assigned.
Requests get closed.

Your job: Build the system.


# Project Objective

Create a Java console application that demonstrates your understanding of:

* Classes
* Fields
* Constructors (default + parameterized)
* Getters & Setters
* Methods
* Loops
* Conditional statements


# Required Files

* `MaintenanceRequest.java`
* `MaintenanceOffice.java` *(starts at Level 3)*
* `Main.java`

---

# Level 1 — Log the Requests

Create a `MaintenanceRequest` class.

It must contain:

* tenantName
* apartmentNumber
* issueType
* severity (1–5)
* status (default = `"NEW"`)

Requirements:

* Include both constructors
* Include getters and setters
* Include a `toString()` method

In `Main`:

* Create at least **3 requests**
* Use a loop to print them
* Print `"HIGH PRIORITY"` if severity ≥ 4

---

# Level 2 — Intake From User

Now allow the user to enter requests.

Requirements:

* Use a loop to continue entering requests
* Stop when user types `"done"`
* After each request:

  * Print confirmation
  * Apply rules:

Rules:

* If issueType is `"Electrical"` and severity ≥ 4 → print warning
* If severity is 5 → dispatch immediately

---

# Level 3 — Assign & Update

Create a `MaintenanceOffice` class.

It must:

* Assign a tech based on severity
* Update request status
* Close completed requests

Only allow status updates to:

* `"NEW"`
* `"IN_PROGRESS"`
* `"DONE"`

Do not close a request unless it is `"DONE"`.

---

# Level 4 — Daily Report

Add a report method that prints:

* Total requests
* Open vs closed
* Count of low / medium / high severity
* Most common issue type

If high priority requests exceed 3:

* Print overload warning

---

# Expectations

Your code should:

* Use methods appropriately
* Use conditionals logically
* Use loops correctly
* Keep data inside objects (use getters/setters)

Avoid:

* Putting all logic in `Main`
* Hardcoding everything
* Skipping constructors

---

# Submission

Submit:

* All `.java` files
* Screenshot or copy of sample console output
* Clean, formatted code

----

# Creative Extension (Optional)

Choose ONE:

* Add estimated repair cost
* Add tenant phone number
* Add technician name field
* Add priority auto-calculation
* Add simple menu system
* Add ability to search by apartment number
* Add daily revenue estimate
* Add time-to-complete tracking
* Add “cancel request” feature
* Add manager approval for high severity

