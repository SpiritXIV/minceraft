# TP the player to the rooms
execute as @a[nbt={Dimension:"minecraft:overworld"}] at @s if block ^ ^ ^ #minecraft:sculk_replaceable_world_gen run execute in shit:backrooms run tp ~ 20 ~
playsound shit:fall_into_backrooms master @p[nbt={Dimension:"shit:backrooms"}] ~ ~ ~ 1 1