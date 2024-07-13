package com.agriculture_platform.Farm.Management.Exception;




public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
