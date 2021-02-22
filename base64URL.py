import base64
import urllib.parse
import argparse

parser = argparse.ArgumentParser(description="Base64 to url encoding and url encoding to Base64")
parser.add_argument("-helpme", "--helpme", type=str, metavar="", required=False, help="help menu")
group = parser.add_mutually_exclusive_group()
group.add_argument("-e","--encode", type=str, dest="encode", required=False, nargs='*', help="Plain text you want encoded")
group.add_argument("-d","--decode", type=str, dest="decode", required=False, help="Encoded text you want decoded")
args = parser.parse_args()

if args.encode:
    message = str(args.encode)
    message_bytes = message.encode('ascii')
    base64_bytes = base64.b64encode(message_bytes)
    base64_message = base64_bytes.decode('ascii')
        
#    print(base64_message)
    encoded = str(urllib.parse.quote(base64_message))
    print(encoded)

elif args.decode:

    decoded = str(urllib.parse.unquote(args.decode))

    base64_message = decoded    
    base64_bytes = base64_message.encode('ascii')
    message_bytes = base64.b64decode(base64_bytes)
    message = message_bytes.decode('ascii')

    print(message)
        
else:
    print("Try -h")
