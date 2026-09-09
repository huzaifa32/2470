-- Get all columns from customer
SELECT * FROM customer;

-- Get all columns from customers in Arizona
SELECT * FROM customer WHERE state='AZ';

-- Get all invoices older than 6 months
SELECT * FROM invoice WHERE invoice_date < NOW() - INTERVAL '6 month';

-- Set all customer phone numbers to NULL that do not follow +1 555 555-5555
UPDATE customer SET phone=NULL WHERE phone !~ '^\+1 \d{3} \d{3}-\d{4}$';

-- Get all tracks longer than 180000ms
SELECT * FROM track WHERE milliseconds > 180000;

-- Set all non USA customers' country to USA and city,state,address to NULL.
UPDATE customer SET country='USA',city=NULL,state=NULL,address=NULL WHERE country != 'USA';

-- Function: return total spending given customer ID
CREATE OR REPLACE FUNCTION total_spending(c_id INT)
RETURNS INT AS $$
BEGIN
    RETURN SUM(total) FROM invoice WHERE customer_id = c_id;
END;
$$ LANGUAGE plpgsql;

SELECT total_spending(2);

CREATE OR REPLACE PROCEDURE update_manager(emp_id INT,new_manager_id INT)
LANGUAGE plpgsql
AS $$
BEGIN

    IF NOT EXISTS (SELECT 1 FROM employee WHERE employee_id = emp_id)
    THEN
        RAISE EXCEPTION 'Employee % not found', emp_id;
    END IF;

    IF NOT EXISTS(SELECT 1 FROM employee WHERE employee_id = new_manager_id)
    THEN
        RAISE EXCEPTION 'Manager % not found', new_manager_id;
    END IF;

    IF EXISTS(SELECT 1 FROM employee WHERE employee_id = new_manager_id AND reports_to = emp_id)
    THEN
        RAISE EXCEPTION 'Circular Management Error';
    END IF;

    IF emp_id != new_manager_id
    THEN
        UPDATE employee SET reports_to = new_manager_id
        WHERE employee_id = emp_id;
    ELSE
        RAISE EXCEPTION 'Employee % cannot report to themselves.', new_manager_id;
    END IF;
END;
$$;

CALL update_manager(3,2);
SELECT * FROM employee WHERE employee_id = 1;
SELECT employee_id,reports_to FROM employee;


