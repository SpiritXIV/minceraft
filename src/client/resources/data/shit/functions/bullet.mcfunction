execute as @e[type=#minecraft:arrows,nbt={inBlockState:{Name:"minecraft:glass"}}] run execute at @e[type=#minecraft:arrows,nbt={inBlockState:{Name:"minecraft:glass"}}] run playsound minecraft:block.glass.break block @a ~ ~ ~ 1 1 1
execute as @e[type=#minecraft:arrows,nbt={inBlockState:{Name:"minecraft:glass"}}] at @s facing entity @s feet run fill ~0.1 ~-0.1 ~0.1 ~-0.1 ~0.1 ~-0.1 air replace #c:glass_blocks
execute as @e[type=#minecraft:arrows,nbt={inBlockState:{Name:"minecraft:glass"}}] run execute at @e[type=#minecraft:arrows,nbt={inBlockState:{Name:"minecraft:glass"}}] run kill @s
execute as @e[type=#minecraft:arrows,nbt={inBlockState:{Name:"minecraft:glass_pane"}}] run execute at @e[type=#minecraft:arrows,nbt={inBlockState:{Name:"minecraft:glass_pane"}}] run playsound minecraft:block.glass.break block @a ~ ~ ~ 1 1 1
execute as @e[type=#minecraft:arrows,nbt={inBlockState:{Name:"minecraft:glass_pane"}}] at @s facing entity @s feet run fill ~0.1 ~-0.1 ~0.1 ~-0.1 ~0.1 ~-0.1 air replace #c:glass_panes
execute as @e[type=#minecraft:arrows,nbt={inBlockState:{Name:"minecraft:glass_pane"}}] run execute at @e[type=#minecraft:arrows,nbt={inBlockState:{Name:"minecraft:glass_pane"}}] run kill @s
execute as @e[type=#minecraft:arrows,nbt={inBlockState:{Name:"minecraft:tinted_glass"}}] run execute at @e[type=#minecraft:arrows,nbt={inBlockState:{Name:"minecraft:tinted_glass"}}] run playsound minecraft:block.glass.break block @a ~ ~ ~ 1 1 1
execute as @e[type=#minecraft:arrows,nbt={inBlockState:{Name:"minecraft:tinted_glass"}}] at @s facing entity @s feet run fill ~0.1 ~-0.1 ~0.1 ~-0.1 ~0.1 ~-0.1 air replace #c:glass_blocks
execute as @e[type=#minecraft:arrows,nbt={inBlockState:{Name:"minecraft:tinted_glass"}}] run execute at @e[type=#minecraft:arrows,nbt={inBlockState:{Name:"minecraft:tinted_glass"}}] run kill @s
execute as @e[type=#minecraft:arrows] run data modify entity @s PierceLevel set value 2
execute as @e[type=#minecraft:arrows] run execute at @s run particle minecraft:smoke ~ ~ ~ 0 0 0 0 1
execute as @e[type=#minecraft:arrows] run execute at @s run particle minecraft:small_flame ~ ~ ~ 0 0 0 0 1
kill @e[type=#minecraft:arrows,nbt={inGround:1b}]