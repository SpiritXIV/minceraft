# TP the player to the rooms
execute as @a[nbt={Dimension:"minecraft:overworld"}] at @s if block ^ ^1 ^ #shit:falling_blocks run execute in shit:backrooms run tp ~ 20 ~
playsound shit:fall_into_backrooms master @p[nbt={Dimension:"minecraft:backrooms"}] ~ ~ ~ 1 1