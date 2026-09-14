

CREATE TABLE IF NOT EXISTS record_logs(
    log_id SERIAL PRIMARY KEY,
    record_id INT NOT NULL,
    field_changed VARCHAR(50),
    last_update TIMESTAMP,
    old_value VARCHAR(50),
    new_value VARCHAR(50)
);



-- trigger function
CREATE OR REPLACE FUNCTION log_customer_changes()
RETURNS TRIGGER
LANGUAGE plpgsql
AS $$
BEGIN

    IF OLD.name IS DISTINCT FROM NEW.name THEN
        INSERT INTO record_logs (record_id, field_changed, last_update, old_value, new_value)
        VALUES (OLD.id, 'name', NOW(), OLD.name, NEW.name);
    END IF;

    IF OLD.email IS DISTINCT FROM NEW.email THEN
        INSERT INTO record_logs (record_id, field_changed, last_update, old_value, new_value)
        VALUES (OLD.id, 'email', NOW(), OLD.email, NEW.email);
    END IF;

    IF OLD.phone IS DISTINCT FROM NEW.phone THEN
        INSERT INTO record_logs (record_id, field_changed, last_update, old_value, new_value)
        VALUES (OLD.id, 'phone', NOW(), OLD.phone, NEW.phone);
    END IF;

    RETURN NEW;
END;
$$;

CREATE TRIGGER customer_logs
AFTER UPDATE ON customer
FOR EACH ROW
EXECUTE FUNCTION log_customer_changes();

