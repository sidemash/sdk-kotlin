# sdk-kotlin
Sdk for live video streaming with Sidemash Cloud in Kotlin 

## Installation
TODO

## Configuration
First, log in your account and create an `AuthAccess` object to query Sidemash Cloud with API. On creation, you will have a token and a privateKey : Use them to initialize a Sidemash client.
```kotlin 
import com.sidemash.SidemashClient
import com.sidemash.Auth

val sdm = SidemashClient(Auth(token = "1234", privateKey ="secret"))
```

## Usage 
### Nomenclature 
The is pretty staright forward, if You have a resource that you want to Get List Update Patch or Delete, the you should do `sdm.{resourceTypeCamelCase}.{operation}({operationArgs})`.


### Get resources
```kotlin
sdm.streamSquare.get(id = "1234")
```

### List resources
```kotlin 
sdm.streamSquare.list(where = "createdTime:in:[Yesterday.14h, Yesterday.15h[")
```
```kotlin 
import com.sidemash.form.ListStreamSquareForm
sdm.streamSquare.list(ListStreamSquareForm(orderBy = "createdTime:ASC,status:DESC"))
```

### Create resources
```kotlin
sdm.streamSquare.create(size = StreamSquare.Size.S,isElastic = false)
```
```kotlin
import com.sidemash.model.StreamSquare
import com.sidemash.form.CreateStreamSquareForm

sdm.streamSquare.create(CreateStreamSquareForm(size = StreamSquare.Size.S, isElastic = false))
```

### Update resources
```kotlin 
sdm.streamSquare.update(id = "1234", newSize = StreamSquare.Size.M)
```
```kotlin 
import com.sidemash.form.UpdateStreamSquareForm

sdm.streamSquare.update(UpdateStreamSquareForm(id = "1234", newSize = StreamSquare.Size.M))
```

### Delete resources 
```kotlin
sdm.streamSquare.delete(id = "1234")
```


