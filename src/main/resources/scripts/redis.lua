local key = KEYS[1]
local value = ARGV[1]
local maxLen = tonumber(ARGV[2])
local score = tonumber(ARGV[3])
redis.call("ZADD", key , score , value)
local result = redis.call("ZCARD", key)
if(result > maxLen)
then
	redis.call("ZREMRANGEBYRANK", key , 0 , result - maxLen)
end
return true