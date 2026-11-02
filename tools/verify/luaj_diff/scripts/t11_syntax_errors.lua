-- Compile-time error surface: the compiler's diagnostics must be identical.
local cases = {
  'x = ',
  'if then end',
  'local 1 = 2',
  'return 1 +',
  "a = 'unterminated",
  'f(',
  'do',
  'local t = {1,2',
  'while true do',
  '1 = 2',
  'function() end',
  'goto nowhere',
  'local function end',
  'return return',
  'a b',
  'local x = 1; x = ;',
  'for i do end',
  'function f(a,) end',
  'print("a" .. )',
  '::a:: ::a::',
  'local a = 1 local a = 2 end',
}
for i = 1, #cases do
  local f, err = load(cases[i], '=case' .. i)
  print(i, cases[i], f ~= nil, err)
end

-- successful loads must behave identically
local ok = load('return 1 + 2')
if ok then print('load-ok', ok()) end
local ok2 = load('local x = 10 return x * 2')
if ok2 then print('load-ok2', ok2()) end
