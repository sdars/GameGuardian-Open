local co = coroutine.create(function(a, b)
  print('co-args', a, b)
  local c = coroutine.yield(a + b)
  print('co-resumed-with', c)
  local d, e = coroutine.yield(c * 2)
  print('co-resumed2', d, e)
  return 'done'
end)
print('status0', coroutine.status(co))
print('resume1', coroutine.resume(co, 1, 2))
print('status1', coroutine.status(co))
print('resume2', coroutine.resume(co, 10))
print('resume3', coroutine.resume(co, 'x', 'y'))
print('status2', coroutine.status(co))
print('resume-dead', coroutine.resume(co))

local gen = coroutine.wrap(function()
  for i = 1, 3 do coroutine.yield(i * i) end
end)
print('wrap', gen(), gen(), gen())

local bad = coroutine.create(function() error('cofail') end)
print('co-error', coroutine.resume(bad))

local nested = coroutine.create(function()
  local inner = coroutine.create(function() coroutine.yield('inner-yield') end)
  print('nested-resume', coroutine.resume(inner))
  coroutine.yield('outer-yield')
  return 'outer-done'
end)
print('nested', coroutine.resume(nested))
print('nested2', coroutine.resume(nested))

local co2 = coroutine.create(function() end)
print('co-isrunning', coroutine.isrunning())
print('co-close', coroutine.resume(co2))
