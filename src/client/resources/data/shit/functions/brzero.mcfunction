# This tries to prevent players dying from fall-damage when they first enter the Backrooms.
execute as @a at @s if entity @s[y=-65,dy=-2000] run tag @s add EnterBR
execute as @a[tag=EnterBR] at @s in shit:backrooms run tp @s ~ 20 ~
execute as @a[tag=EnterBR] run effect give @s minecraft:slow_falling 10 0 true
execute as @a[tag=EnterBR] run tag @s remove EnterBR
# Rarely, a player will spawn in above the top of the map, this tries to correct that.
execute as @a[nbt={Dimension:"shit:backrooms"},gamemode=!spectator,gamemode=!creative] at @s if entity @s[y=60,dy=68] run tp @s ~ 20 ~
# Sometimes a player will spawn in walls, or an area without backrooms, this tries to move them till they're in an open hallway.
execute as @a[nbt={Dimension:"shit:backrooms"},gamemode=!spectator] at @s if block ~ ~ ~ shit:backrooms_wallpaper_lip run tp @s ~4 ~ ~
# Keeps correctly generated exit-doors alive, letting mis-generated ones expire.
execute as @e[type=falling_block,tag=noclip] at @s if block ~ 22 ~ stripped_birch_wood run data merge entity @s {Time:1}
# This section makes the flickering lights work.
execute as @e[type=marker,tag=flicker] at @s if block ~ ~ ~ air run setblock ~ ~ ~ light[level=0]
execute as @e[type=marker,tag=flicker] at @s if block ~ ~ ~ light[level=1] run setblock ~ ~ ~ light[level=0]
execute as @e[type=marker,tag=flicker] at @s if block ~ ~ ~ light[level=2] run setblock ~ ~ ~ light[level=1]
execute as @e[type=marker,tag=flicker] at @s if block ~ ~ ~ light[level=3] run setblock ~ ~ ~ light[level=2]
execute as @e[type=marker,tag=flicker] at @s if block ~ ~ ~ light[level=4] run setblock ~ ~ ~ light[level=3]
execute as @e[type=marker,tag=flicker] at @s if block ~ ~ ~ light[level=5] run setblock ~ ~ ~ light[level=4]
execute as @e[type=marker,tag=flicker] at @s if block ~ ~ ~ light[level=6] run setblock ~ ~ ~ light[level=5]
execute as @e[type=marker,tag=flicker] at @s if block ~ ~ ~ light[level=7] run setblock ~ ~ ~ light[level=6]
execute as @e[type=marker,tag=flicker] at @s if block ~ ~ ~ light[level=8] run setblock ~ ~ ~ light[level=7]
execute as @e[type=marker,tag=flicker] at @s if block ~ ~ ~ light[level=9] run setblock ~ ~ ~ light[level=8]
execute as @e[type=marker,tag=flicker] at @s if block ~ ~ ~ light[level=10] run setblock ~ ~ ~ light[level=9]
execute as @e[type=marker,tag=flicker] at @s if block ~ ~ ~ light[level=11] run setblock ~ ~ ~ light[level=10]
execute as @e[type=marker,tag=flicker] at @s if block ~ ~ ~ light[level=12] run setblock ~ ~ ~ light[level=11]
execute as @e[type=marker,tag=flicker] at @s if block ~ ~ ~ light[level=13] run setblock ~ ~ ~ light[level=12]
execute as @e[type=marker,tag=flicker] at @s if block ~ ~ ~ light[level=14] run setblock ~ ~ ~ light[level=13]
execute as @e[type=marker,tag=flicker] at @s if block ~ ~ ~ light[level=15] run setblock ~ ~ ~ light[level=14]
# randomly decides when to flicker, sometimes with a double flash.
execute as @e[type=marker,tag=flicker] at @s if block ~ ~ ~ light[level=11] if predicate shit:flicker_r run setblock ~ ~ ~ light[level=15]
execute as @e[type=marker,tag=flicker] at @s if block ~ ~ ~ light[level=0] if predicate shit:flicker_r run setblock ~ ~ ~ light[level=15]
# plays a couple notes which together sorta sound like a fluorescent bulb flickering.
execute as @e[type=marker,tag=flicker] at @s if block ~ ~ ~ light[level=15] in shit:backrooms run playsound shit:light_flicker master @a[nbt={Dimension:"shit:backrooms"}] ~ ~ ~ 0.2 1.4
execute as @e[type=marker,tag=flicker] at @s anchored eyes if block ~ ~ ~ light[level=15] in shit:backrooms run particle minecraft:flame ^ ^1 ^ 0 0 0 0.1 2 force @a
execute as @e[type=marker,tag=flicker] at @s anchored eyes if block ~ ~ ~ light[level=15] in shit:backrooms run particle minecraft:ash ^ ^1 ^ 0 0 0 2 10 force @a
# removes the invisible light block and marker entity, if the block no longer exists.
execute as @e[type=marker,tag=flicker] at @s unless block ~ ~1 ~ shit:backrooms_light_off run setblock ~ ~ ~ air
execute as @e[type=marker,tag=flicker] at @s unless block ~ ~1 ~ shit:backrooms_light_off run kill @s
# TP the player to the next level
execute at @a[nbt={Dimension:"shit:backrooms"}] if block ~ ~-1 ~ shit:backrooms_floor_teleport run function shit:tplevel1
