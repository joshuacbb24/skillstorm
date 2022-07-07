select *
from playlist
join playlisttrack
on playlist.PlaylistId = playlisttrack.PlaylistId
where playlist.PlaylistId = 3;