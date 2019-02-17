"""
    Task 1, Exercise 10
    Oliver Strassmann
    HS18, Informatik I
"""


from base64_encoder import encode_base64_str as encode
from base64_decoder import decode_base64_str as decode

# # "local version" - bei mir lokal verwendete Import statements
# from Ex_10.base64_encoder import encode_base64_str as encode
# from Ex_10.base64_decoder import decode_base64_str as decode


def verify_encoding_decoding(string):
    """
    Takes a string, encodes it and decodes it again and checks whether the result is the same as the input string.
    :param string: input to be checked
    :return: Return the result of this comparison as a boolean value.
    """
    original = string
    encode(string)
    decode(string)

    return original == string


if __name__ == '__main__':
    # verify_encoding_decoding should return true
    assert verify_encoding_decoding("devRant5_t")
