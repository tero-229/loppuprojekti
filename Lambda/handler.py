import json
import boto3
import os
from botocore.vendored import requests
from boto3.dynamodb.conditions import Key, Attr
import datetime

dynamodb = boto3.resource('dynamodb', region_name='eu-west-1')
table = dynamodb.Table('ystava-viestit-3')
CHARSET = 'UTF-8'

def saveYstavaQDB(content, receiver):
    response = table.put_item(
        Item={
            'receiver': receiver,
            'content': content
            }
    )

def sendEmail(event, context):
    data = event['body']
    receiver = data ['receiver']    
    source = data['source']    
    subject = data['subject']
    content = data['content']   
    destination = data['destination']
    timestamp = datetime.datetime.now()


    _message = "Lähettäjä: " + receiver + ": " + content + "." + str(timestamp) + "." 
    saveYstavaQDB(content, receiver)
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

