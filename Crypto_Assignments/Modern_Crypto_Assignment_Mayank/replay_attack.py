import time

tokens = {}

def authenticate(user):
    token = str(time.time())
    tokens[user] = token
    return token

def validate(user, token):
    return tokens.get(user) == token

# User logs in
user_token = authenticate("Mayank")
print("Generated Token:", user_token)

# Replay old token
time.sleep(2)
replayed = validate("Mayank", user_token)
print("Replayed Token Valid?", replayed)
