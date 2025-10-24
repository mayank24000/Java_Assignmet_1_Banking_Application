from Crypto.Cipher import AES
from Crypto.Random import get_random_bytes

plaintext = b"Confidential Transaction Confidential Transaction"
key = get_random_bytes(16)

def pad(text):
    pad_len = 16 - len(text) % 16
    return text + bytes([pad_len]) * pad_len

def unpad(text):
    return text[:-text[-1]]

modes = {
    "ECB": AES.MODE_ECB,
    "CBC": AES.MODE_CBC,
    "CFB": AES.MODE_CFB,
    "OFB": AES.MODE_OFB,
    "CTR": AES.MODE_CTR
}

for name, mode in modes.items():
    if mode in (AES.MODE_CBC, AES.MODE_CFB, AES.MODE_OFB):
        iv = get_random_bytes(16)
        cipher = AES.new(key, mode, iv=iv)
    elif mode == AES.MODE_CTR:
        cipher = AES.new(key, mode)
    else:
        cipher = AES.new(key, mode)
    ct = cipher.encrypt(pad(plaintext))
    print(f"{name} ciphertext: {ct.hex()[:50]}...")
