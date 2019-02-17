"""
    Task 1, Exercise 10
    Oliver Strassmann
    HS18, Informatik I
"""


from base64 import urlsafe_b64encode


def encode_base64_str(string):
    """
    :param string: string to be encoded
    :return: encoded string
    """

    # convert string to bytes-> encode string-> change encoded string (in bytes) back to normal
    encoded_str = urlsafe_b64encode(string.encode('ascii')).decode('ascii')

    return encoded_str
