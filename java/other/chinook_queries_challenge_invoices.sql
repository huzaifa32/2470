DROP VIEW IF EXISTS customer_invoices;

-- Get all invoice ids with the customers first name, last name, and the invoice total
CREATE VIEW customer_invoices AS
SELECT invoice.invoice_id,customer.first_name,customer.last_name,invoice.total 
FROM invoice
JOIN customer
ON invoice.customer_id = customer.customer_id;

-- invoices over $30
SELECT * 
FROM customer_invoices
WHERE total > 30;


-- get all invoices from USA and within past 6 months, using CTE.
WITH us_invoices AS(
    SELECT * 
    FROM invoice
    WHERE billing_country = 'USA'
)
SELECT *
FROM us_invoices
WHERE invoice_date > NOW() - INTERVAL '6 month';