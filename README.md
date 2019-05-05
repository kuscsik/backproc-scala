Simple play framework app to run async backend commands


Sample usage:

Post Json to **/pipe** endpoint:

```json
{
	"commands" : ["ls /tmp", "ls /tmp"]
}
```

Returns the list of results:
```
{"result":[["ls /tmp","xxxxx"],["ls /tmp","xxxxxx"]]}
``

where **xxxxx** is a Base64 encoded string.

