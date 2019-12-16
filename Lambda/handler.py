import json
import boto3
import os
from botocore.vendored import requests
from boto3.dynamodb.conditions import Key, Attr

dynamodb = boto3.resource('dynamodb', region_name='eu-west-1')
table = dynamodb.Table('ystava-viestit-2')
CHARSET = 'UTF-8'

def saveYstavaQDB(content, sender):
    response = table.put_item(
        Item={
            'sender': sender,
            'content': content
            }
    )

def sendEmail(event, context):
    data = event['body']
    sender = data ['sender']    
    source = data['source']    
    subject = data['subject']
    content = data['content']   
    destination = data['destination']
    #timestamp = data['timestamp']

    _message = "Message from: " + sender + ". Email: " + source + ". Message content: " + content + "." 
    saveYstavaQDB(content, sender)
    client = boto3.client('ses' )    
        
    response = client.send_email(
        Destination={
            'ToAddresses': [destination]
            },
        Message={
            'Body': {
                'Text': {
                    'Charset': 'UTF-8',
                    'Data': _message,
                },
            },               
            'Subject': {
                'Charset': 'UTF-8',
                'Data': subject,
            },
        },
        Source=source,
    )
    return _message

