import hashlib

filename = "sample_input.txt"
with open(filename, "rb") as f:
    data = f.read()

print("MD5:", hashlib.md5(data).hexdigest())
print("SHA-1:", hashlib.sha1(data).hexdigest())
print("SHA-256:", hashlib.sha256(data).hexdigest())

