from Crypto.Cipher import DES, DES3, AES
from Crypto.Random import get_random_bytes
import time

plaintext = b"Confidential Transaction"

def pad(text, block_size):
    padding_len = block_size - len(text) % block_size
    return text + bytes([padding_len]) * padding_len

def unpad(text):
    return text[:-text[-1]]

# DES
key_des = get_random_bytes(8)
cipher_des = DES.new(key_des, DES.MODE_ECB)
start = time.time()
ct_des = cipher_des.encrypt(pad(plaintext, 8))
end = time.time()
print("DES Ciphertext:", ct_des.hex(), "Time:", round(end-start, 6), "s")

# 3DES
key_3des = DES3.adjust_key_parity(get_random_bytes(24))
cipher_3des = DES3.new(key_3des, DES3.MODE_ECB)
start = time.time()
ct_3des = cipher_3des.encrypt(pad(plaintext, 8))
end = time.time()
print("3DES Ciphertext:", ct_3des.hex(), "Time:", round(end-start, 6), "s")

# AES
key_aes = get_random_bytes(16)
cipher_aes = AES.new(key_aes, AES.MODE_ECB)
start = time.time()
ct_aes = cipher_aes.encrypt(pad(plaintext, 16))
end = time.time()
print("AES Ciphertext:", ct_aes.hex(), "Time:", round(end-start, 6), "s")
