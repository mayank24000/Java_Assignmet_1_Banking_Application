import hmac, hashlib

key = b'secret_key'
filename = "sample_input.txt"

with open(filename, "rb") as f:
    data = f.read()

# Original HMAC
hmac_val = hmac.new(key, data, hashlib.sha256).hexdigest()
print("Original HMAC:", hmac_val)

# Modify file content
modified_data = data + b" extra text"
new_hmac_val = hmac.new(key, modified_data, hashlib.sha256).hexdigest()
print("Modified HMAC:", new_hmac_val)

if hmac_val != new_hmac_val:
    print("Data integrity compromised!")
